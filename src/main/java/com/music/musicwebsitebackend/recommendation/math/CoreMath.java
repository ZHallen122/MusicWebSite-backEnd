package com.music.musicwebsitebackend.recommendation.math;

import com.google.common.collect.Lists;
import com.music.musicwebsitebackend.recommendation.DataType.RelatedData;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CoreMath {

    /**
     * recommend
     *
     * @param user_id
     * @param list recommend list set
     * @return
     */
    public List<Integer> recommend (Integer user_id, List<RelatedData> list) {
        Map<Double, Integer> distances = computeNearestNeighbor(user_id, list);
        Integer nearest = null;
        if (!distances.isEmpty()) {
            nearest = distances.values().iterator().next();
        }
        Iterator<Integer> iterator = distances.values().iterator();
        while(iterator.hasNext()){
            nearest = iterator.next();
        }
        Map<Integer, List<RelatedData>> userMap =list.stream().collect(Collectors.groupingBy(RelatedData::getUserId));

        // Near least user check item id list
        List<Integer> neighborItemList = userMap.get(nearest).stream().map(e->e.getProductId()).collect(Collectors.toList());
        // The user check item id list
        List<Integer> userItemList  = userMap.get(user_id).stream().map(e->e.getProductId()).collect(Collectors.toList());

        // Find the near least history, to find the user havent see
        List<Integer> recommendList = new ArrayList<>();
        for (Integer item : neighborItemList) {
            if (!userItemList.contains(item)) {
                recommendList.add(item);
            }
        }
        Collections.sort(recommendList);
        return recommendList;
    }

    /**
     * given user_id, cauculate the other user and their Pearson correlation coefficient
     *
     * @param user_id
     * @param list
     * @return
     */
    private Map<Double, Integer> computeNearestNeighbor(Integer user_id, List<RelatedData> list) {
        Map<Integer, List<RelatedData>> userMap = list.stream().collect(Collectors.groupingBy(RelatedData::getUserId));
        //treemap ascending order
        Map<Double, Integer> distances = new TreeMap<>();
        userMap.forEach((k,v)->{
            if(k.intValue() != user_id.intValue()){
                double distance = pearson_dis(v,userMap.get(user_id));
                distances.put(distance, k);
            }
        });
        return distances;
    }

    /**
     * Calculate the correlation coefficient between two series
     *
     * @param xList  other user
     * @param yList  cur user
     * @return
     */
    private double pearson_dis(List<RelatedData> xList, List<RelatedData> yList) {
        List<Integer> xs= Lists.newArrayList();
        List<Integer> ys= Lists.newArrayList();
        xList.forEach(x->{
            yList.forEach(y->{
                if(x.getProductId().intValue() == y.getProductId().intValue()){
                    xs.add(x.getIndex());
                    ys.add(y.getIndex());
                }
            });
        });
        return getRelate(xs,ys);
    }

    /**
     * Method description: Pearson's correlation coefficient calculation
     * (x1,y1) is interpreted as the number of clicks by a user on product x and the number of clicks on product y
     * @param xs
     * @param ys
     * @Return {@link Double}
     */
    public static Double getRelate(List<Integer> xs, List<Integer> ys) {
        int n=xs.size();
        double Ex= xs.stream().mapToDouble(x->x).sum();
        double Ey=ys.stream().mapToDouble(y->y).sum();
        double Ex2=xs.stream().mapToDouble(x-> Math.pow(x,2)).sum();
        double Ey2=ys.stream().mapToDouble(y-> Math.pow(y,2)).sum();
        double Exy= IntStream.range(0,n).mapToDouble(i->xs.get(i)*ys.get(i)).sum();
        double numerator=Exy-Ex*Ey/n;
        double denominator= Math.sqrt((Ex2- Math.pow(Ex,2)/n)*(Ey2- Math.pow(Ey,2)/n));
        if (denominator==0) {
            return 0.0;
        }
        return numerator/denominator;
    }

}
