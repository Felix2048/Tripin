package com.tripin.application.utils;

import com.tripin.application.entity.Pin;
import com.tripin.application.entity.Route;

import java.util.ArrayList;
import java.util.List;

public class TSPUtil {

    /**
     * Gets length of the shortest Hamiltonian cycle and back pointers for building the shortest path.
     * O(2^|V| |V|^2)<br>
     * AOJ No. 0120, 0146(partial modification, Semi-Hamilton graph)
     *
     * @param G adjacency matrix
     * @param s source node (※= destination node)
     * @return TSPResult
     */
    static List<Integer> TSP(double[][] G, int s) {

        int length = G.length;
        List<Integer> result = new ArrayList<>();
        result.add(s);

        //只用寻找 length-2 次
        for (int i = 0; i < length - 1; i++) {
            result.add(getNearest(G, result, result.get(result.size() - 1)));
        }
        return result;
    }

    static int getNearest(double[][] G, List<Integer> excludeList, int s) {
        double min = Double.MAX_VALUE;
        int index = 0;
        for (int i = 0; i < G.length; i++) {
            if (i == s || excludeList.contains(i)) {
                continue;
            }
            if (G[s][i] < min) {
                min = G[s][i];
                index = i;
            }
        }
        return index;
    }

    public static List<Pin> getOrderedPins(List<Pin> pinList, List<Route> routeList) {

        //计数变量
        int i, j = 0;
        int pinListSize = pinList.size();

        //定义并计算distanceMap
        double distanceMap[][] = new double[pinListSize][pinListSize];
        for (i = 0; i < pinListSize - 1; i++) {
            for (j = i + 1; j < pinListSize; j++) {
                distanceMap[i][j] = distanceMap[j][i] = getRouteDistanceByPins(pinList.get(i), pinList.get(j), routeList);
            }
        }
        for (i = 0; i < pinListSize; i++) {
            distanceMap[i][i] = 0;
        }
        for (i = 0; i < pinListSize ; i++) {
            for (j = 0; j < pinListSize; j++) {
                System.out.print(distanceMap[i][j] + " ");
            }
            System.out.println();
        }

        List<Integer> tspResult = TSP(distanceMap, 0);
        List<Pin> orderedPins = new ArrayList<>();
        for (Integer index : tspResult) {
            orderedPins.add(pinList.get(index));
        }

        return orderedPins;
    }

    private static double getRouteDistanceByPins(Pin origin, Pin destination, List<Route> routeList) {
        for (Route route : routeList) {
            if (route.getOrigin() == origin.getPinID() && route.getDestination() == destination.getPinID()) {
                return route.getRouteDistance();
            }
        }
        return Double.POSITIVE_INFINITY;
    }
}