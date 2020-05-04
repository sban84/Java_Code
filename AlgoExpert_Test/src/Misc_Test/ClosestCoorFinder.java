package Misc_Test;

import java.io.*;
import java.util.*;


// for pairs in 2 sorted array :- https://www.geeksforgeeks.org/given-two-sorted-arrays-number-x-find-pair-whose-sum-closest-x/
// Find pairs whose diff is smallest (unsorted array) :- https://www.geeksforgeeks.org/smallest-difference-pair-values-two-unsorted-arrays/
// find missing number range [1, N] :- https://www.geeksforgeeks.org/find-missing-elements-from-an-array/?ref=leftbar-rightbar

public class ClosestCoorFinder {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String line = System.getProperty("line.separator");
        scan.useDelimiter(line);

        List<Coordinate> points = new ArrayList<>();
        Random random = new Random();
        for (int x=0;x<1000;x++){
            points.add(new Coordinate(random.nextInt(),random.nextInt(), x));
        }


        long startTime = System.currentTimeMillis();
        CoordinateDetail bruteForceClosestPair = bruteForce(points);
        long elapsedTime = System.currentTimeMillis() - startTime;
        System.out.println("Brute force (" + elapsedTime + " ms): " + bruteForceClosestPair);
        
        
        startTime = System.currentTimeMillis();
        CoordinateDetail dqClosestPair = divideAndConquer(points);
        elapsedTime = System.currentTimeMillis() - startTime;
        System.out.println("Divide and conquer (" + elapsedTime + " ms): " + dqClosestPair);
    }


    private static class Coordinate {
        private double x;
        private double y;
		private int id;

        public Coordinate(int id, double x, double y) {
            this.id = id;
            this.x = x;
            this.y = y;
        }

        public int getId() {
            return id;
        }

        public double getX() {
            return x;
        }

        public double getY() {
            return y;
        }

        public String toString() {
            return "(" + x + ", " + y +")";
        }
    }

    private static class CoordinateDetail {
        private Coordinate point1 = null;
        private Coordinate point2 = null;
        private double distance = 0.0;

        public CoordinateDetail(Coordinate point1, Coordinate point2, double distance) {
            this.point1 = point1;
            this.point2 = point2;
            this.distance = distance;
        }

        public Coordinate getPoint1() {
            return point1;
        }

        public Coordinate getPoint2() {
            return point2;
        }


        public double getDistance() {
            return distance;
        }


        public void set(Coordinate point1, Coordinate point2, double distance) {
            this.point1 = point1;
            this.point2 = point2;
            this.distance = distance;
        }

        public String toString() {
            return getPoint1() +" "+getPoint2()+" : distance = "+getDistance();
        }
    }

    private static double calDistance(Coordinate p1, Coordinate p2) {
        double xdist = p2.getX() - p1.getX();
        double ydist = p2.getY() - p1.getY();
        return Math.hypot(xdist, ydist);
    }

    // much faster than DnV for list of Coordinate is less than 100
    private static CoordinateDetail bruteForce(List<Coordinate> points) {
        int coorSize = points.size();
        if (coorSize < 2)
            return null;

        CoordinateDetail coorPoint = new CoordinateDetail(points.get(0), points.get(1),calDistance(points.get(0), points.get(1)));
        if (coorSize > 2) {
            for (int i = 0; i < coorSize - 1; i++) {
                Coordinate point1 = points.get(i);
                for (int j = i + 1; j < coorSize; j++) {
                    Coordinate point2 = points.get(j);
                    double distance = calDistance(point1, point2);
                    if (distance < coorPoint.getDistance())
                        coorPoint.set(point1, point2, distance);
                }
            }
        }
        return coorPoint;
    }

    private static void sortByX(List<Coordinate> points) {
        Collections.sort(points, new Comparator < Coordinate > () {
            public int compare(Coordinate point1, Coordinate point2) {
                if (point1.getX() < point2.getX())
                    return -1;
                if (point1.getX() > point2.getX())
                    return 1;
                return 0;
            }
        });
    }

    private static void sortByY(List<Coordinate> points) {
        Collections.sort(points, new Comparator <Coordinate> () {
            public int compare(Coordinate point1, Coordinate point2) {
                if (point1.getY() < point2.getY())
                    return -1;
                if (point1.getY() > point2.getY())
                    return 1;
                return 0;
            }
        });
    }

    // much faster than bruteforce for list of Coordinate is more than 100
    public static CoordinateDetail divideAndConquer(List<Coordinate> points) {
        List<Coordinate> listofSortedX = new ArrayList<> (points);
        sortByX(listofSortedX);
        List<Coordinate> listofSortedY = new ArrayList<> (points);
        sortByY(listofSortedY);
        return divideAndConquer(listofSortedX, listofSortedY);
    }

    private static CoordinateDetail divideAndConquer(List<Coordinate> listofSortedX, List<Coordinate> listofSortedY) {
        int coorSize = listofSortedX.size();
        if (coorSize <= 3)
            return bruteForce(listofSortedX);

        int index = coorSize >>> 1;
        List<Coordinate>leftOfCenter = listofSortedX.subList(0, index);
        List<Coordinate>rightOfCenter = listofSortedX.subList(index, coorSize);

        List<Coordinate>tempList= new ArrayList<>(leftOfCenter);
        sortByY(tempList);

        CoordinateDetail closestPair = divideAndConquer(leftOfCenter, tempList);

        tempList.clear();

        tempList.addAll(rightOfCenter);
        sortByY(tempList);

        CoordinateDetail closestPairRight = divideAndConquer(rightOfCenter, tempList);

        if (closestPairRight.getDistance() < closestPair.getDistance())
            closestPair = closestPairRight;

        tempList.clear();

        double shortestDistance = closestPair.getDistance();
        double centerX = rightOfCenter.get(0).getX();
        for (Coordinate point: listofSortedY)
            if (Math.abs(centerX - point.getX()) < shortestDistance)
                tempList.add(point);

        for (int i=0; i<tempList.size()-1;i++) {
            Coordinate point1 = tempList.get(i);
            for (int j=i+1;j<tempList.size();j++) {
                Coordinate point2 = tempList.get(j);
                if ((point2.getY() - point1.getY()) >= shortestDistance)
                    break;
                double distance = calDistance(point1, point2);
                if (distance < closestPair.getDistance()) {
                    closestPair.set(point1, point2, distance);
                    shortestDistance = distance;
                }
            }
        }
        return closestPair;
    }

}