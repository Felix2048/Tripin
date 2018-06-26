package com.tripin.application.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TespUtil {
    /**
     * Gets length of the shortest Hamiltonian cycle and back pointers for building the shortest path.
     * O(2^|V| |V|^2)<br>
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

    @RequiresApi(api = Build.VERSION_CODES.N)
    public static List<Pin> getOrderedPins(List<Pin> pinList) {

        //计数变量
        int i, j = 0;
        int pinListSize = pinList.size();

//        DistanceUtil.getDistance()
        List<LatLng> latLngList = pinList.stream().map(Pin::getLatLng).collect(Collectors.toList());

        //定义并计算distanceMap
        double distanceMap[][] = new double[pinListSize][pinListSize];
        for (i = 0; i < pinListSize - 1; i++) {
            for (j = i + 1; j < pinListSize; j++) {
//                System.out.println(i+"  " +j);
                //todo
                distanceMap[i][j] = distanceMap[j][i] = DistanceUtil.getDistance(latLngList.get(i), latLngList.get(j));
//                double distance = Math.sqrt(Math.pow((latLngList.get(i).latitude - latLngList.get(j).latitude), 2) + Math.pow(latLngList.get(i).longitude - latLngList.get(j).longitude, 2));
//                distanceMap[i][j] = distanceMap[j][i] =  distance;
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

}
