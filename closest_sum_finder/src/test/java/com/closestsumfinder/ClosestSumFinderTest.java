package com.closestsumfinder;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import com.closetsumfinder.ClosestSumFinder;
import com.closetsumfinder.ClosestSumFinder.Item;

class ClosestSumFinderTest {
    @Test
    void testCase1() {

        Item item1 = Item.builder().identifier("ITEM1").value(BigDecimal.valueOf(400_000)).build();
        Item item2 = Item.builder().identifier("ITEM2").value(BigDecimal.valueOf(110_000)).build();

        List<Item> closestCombination =
            ClosestSumFinder.findClosestSum(Stream.of(item1, item2).collect(Collectors.toList()), BigDecimal.valueOf(500_000));

        assertThat(closestCombination.stream().map(Item::getValue).reduce(BigDecimal.ZERO, BigDecimal::add))
            .isEqualByComparingTo(BigDecimal.valueOf(400_000));
        Assertions.assertThat(closestCombination).containsExactlyInAnyOrderElementsOf(Collections.singletonList(item1));

    }

    @Test
    void testCase2() {

        Item item1 = Item.builder().identifier("ITEM1").value(BigDecimal.valueOf(400_000)).build();
        Item item2 = Item.builder().identifier("ITEM2").value(BigDecimal.valueOf(50_000)).build();
        Item item3 = Item.builder().identifier("ITEM3").value(BigDecimal.valueOf(60_000)).build();

        List<Item> closestCombination =
            ClosestSumFinder.findClosestSum(Stream.of(item1, item2, item3).collect(Collectors.toList()), BigDecimal.valueOf(500_000));

        assertThat(closestCombination.stream().map(Item::getValue).reduce(BigDecimal.ZERO, BigDecimal::add))
            .isEqualByComparingTo(BigDecimal.valueOf(460_000));
        Assertions.assertThat(closestCombination).containsExactlyInAnyOrderElementsOf(Arrays.asList(item1, item3));

    }

    @Test
    void testCase3() {

        Item item1 = Item.builder().identifier("ITEM1").value(BigDecimal.valueOf(400_000)).build();
        Item item2 = Item.builder().identifier("ITEM2").value(BigDecimal.valueOf(30_000)).build();
        Item item3 = Item.builder().identifier("ITEM3").value(BigDecimal.valueOf(40_000)).build();
        Item item4 = Item.builder().identifier("ITEM4").value(BigDecimal.valueOf(50_000)).build();

        List<Item> closestCombination =
            ClosestSumFinder
                .findClosestSum(Stream.of(item1, item2, item3, item4).collect(Collectors.toList()), BigDecimal.valueOf(500_000));

        assertThat(closestCombination.stream().map(Item::getValue).reduce(BigDecimal.ZERO, BigDecimal::add))
            .isEqualByComparingTo(BigDecimal.valueOf(490_000));
        Assertions.assertThat(closestCombination).containsExactlyInAnyOrderElementsOf(Arrays.asList(item1, item3, item4));

    }

    @Test
    void testCase4() {

        Item item1 = Item.builder().identifier("ITEM1").value(BigDecimal.valueOf(400_000)).build();
        Item item2 = Item.builder().identifier("ITEM2").value(BigDecimal.valueOf(30_000)).build();
        Item item3 = Item.builder().identifier("ITEM3").value(BigDecimal.valueOf(40_000)).build();
        Item item4 = Item.builder().identifier("ITEM4").value(BigDecimal.valueOf(50_000)).build();
        Item item5 = Item.builder().identifier("ITEM5").value(BigDecimal.valueOf(5_000)).build();

        List<Item> closestCombination =
            ClosestSumFinder
                .findClosestSum(Stream.of(item1, item2, item3, item4, item5).collect(Collectors.toList()), BigDecimal.valueOf(500_000));

        assertThat(closestCombination.stream().map(Item::getValue).reduce(BigDecimal.ZERO, BigDecimal::add))
            .isEqualByComparingTo(BigDecimal.valueOf(495_000));
        Assertions.assertThat(closestCombination).containsExactlyInAnyOrderElementsOf(Arrays.asList(item1, item3, item4, item5));

    }

    @Test
    void testCase5() {

        Item item1 = Item.builder().identifier("ITEM1").value(BigDecimal.valueOf(400_000)).build();
        Item item2_1 = Item.builder().identifier("ITEM2_1").value(BigDecimal.valueOf(30_000)).build();
        Item item2_2 = Item.builder().identifier("ITEM2_2").value(BigDecimal.valueOf(30_000)).build();
        Item item2_3 = Item.builder().identifier("ITEM2_3").value(BigDecimal.valueOf(30_000)).build();
        Item item3 = Item.builder().identifier("ITEM3").value(BigDecimal.valueOf(30_000)).build();
        Item item4 = Item.builder().identifier("ITEM4").value(BigDecimal.valueOf(5_000)).build();
        Item item5 = Item.builder().identifier("ITEM5").value(BigDecimal.valueOf(6_000)).build();

        List<Item> closestCombination =
            ClosestSumFinder
                .findClosestSum(
                    Stream.of(item1, item2_1, item2_2, item2_3, item3, item4, item5).collect(Collectors.toList()),
                    BigDecimal.valueOf(500_000));

        assertThat(closestCombination.stream().map(Item::getValue).reduce(BigDecimal.ZERO, BigDecimal::add))
            .isEqualByComparingTo(BigDecimal.valueOf(496_000));
        Assertions.assertThat(closestCombination)
            .containsExactlyInAnyOrderElementsOf(Arrays.asList(item1, item2_1, item2_2, item2_3, item5));

    }

    @Test
    void testCase6() {

        Item item1 = Item.builder().identifier("ITEM1").value(BigDecimal.valueOf(400_000)).build();
        Item item2_1 = Item.builder().identifier("ITEM2_1").value(BigDecimal.valueOf(30_000)).build();
        Item item2_2 = Item.builder().identifier("ITEM2_2").value(BigDecimal.valueOf(30_000)).build();
        Item item2_3 = Item.builder().identifier("ITEM2_3").value(BigDecimal.valueOf(30_000)).build();
        Item item2_4 = Item.builder().identifier("ITEM2_4").value(BigDecimal.valueOf(30_000)).build();
        Item item3 = Item.builder().identifier("ITEM3").value(BigDecimal.valueOf(30_000)).build();
        Item item4 = Item.builder().identifier("ITEM4").value(BigDecimal.valueOf(5_000)).build();
        Item item5 = Item.builder().identifier("ITEM5").value(BigDecimal.valueOf(6_000)).build();

        List<Item> closestCombination =
            ClosestSumFinder
                .findClosestSum(
                    Stream.of(item1, item2_1, item2_2, item2_3, item2_4, item3, item4, item5).collect(Collectors.toList()),
                    BigDecimal.valueOf(500_000));

        assertThat(closestCombination.stream().map(Item::getValue).reduce(BigDecimal.ZERO, BigDecimal::add))
            .isEqualByComparingTo(BigDecimal.valueOf(496_000));
        Assertions.assertThat(closestCombination)
            .containsExactlyInAnyOrderElementsOf(Arrays.asList(item1, item2_1, item2_2, item2_3, item5));

    }

    @Test
    void testCase7() {

        Item item1 = Item.builder().identifier("ITEM1").value(BigDecimal.valueOf(510_000)).build();
        Item item2 = Item.builder().identifier("ITEM2").value(BigDecimal.valueOf(520_000)).build();
        Item item3 = Item.builder().identifier("ITEM3").value(BigDecimal.valueOf(530_000)).build();
        Item item4 = Item.builder().identifier("ITEM4").value(BigDecimal.valueOf(540_000)).build();

        List<Item> closestCombination =
            ClosestSumFinder
                .findClosestSum(
                    Stream.of(item1, item2, item3, item4).collect(Collectors.toList()),
                    BigDecimal.valueOf(500_000));

        assertThat(closestCombination.stream().map(Item::getValue).reduce(BigDecimal.ZERO, BigDecimal::add))
            .isEqualByComparingTo(BigDecimal.valueOf(0));
        Assertions.assertThat(closestCombination).containsExactlyInAnyOrderElementsOf(Collections.emptyList());

    }

    @Test
    void testCase8() {

        Item item1 = Item.builder().identifier("ITEM1").value(BigDecimal.valueOf(510_000)).build();
        Item item2 = Item.builder().identifier("ITEM2").value(BigDecimal.valueOf(20_000)).build();
        Item item3 = Item.builder().identifier("ITEM3").value(BigDecimal.valueOf(30_000)).build();
        Item item4 = Item.builder().identifier("ITEM4").value(BigDecimal.valueOf(40_000)).build();

        List<Item> closestCombination =
            ClosestSumFinder
                .findClosestSum(
                    Stream.of(item1, item2, item3, item4).collect(Collectors.toList()),
                    BigDecimal.valueOf(500_000));

        assertThat(closestCombination.stream().map(Item::getValue).reduce(BigDecimal.ZERO, BigDecimal::add))
            .isEqualByComparingTo(BigDecimal.valueOf(90_000));
        Assertions.assertThat(closestCombination).containsExactlyInAnyOrderElementsOf(Arrays.asList(item2, item3, item4));

    }

    @Test
    void testCase9() {

        Item item1 = Item.builder().identifier("ITEM1").value(BigDecimal.valueOf(500_000)).build();
        Item item2 = Item.builder().identifier("ITEM2").value(BigDecimal.valueOf(10_000)).build();
        Item item3 = Item.builder().identifier("ITEM3").value(BigDecimal.valueOf(20_000)).build();
        Item item4 = Item.builder().identifier("ITEM4").value(BigDecimal.valueOf(30_000)).build();

        List<Item> closestCombination =
            ClosestSumFinder
                .findClosestSum(
                    Stream.of(item1, item2, item3, item4).collect(Collectors.toList()),
                    BigDecimal.valueOf(500_000));

        assertThat(closestCombination.stream().map(Item::getValue).reduce(BigDecimal.ZERO, BigDecimal::add))
            .isEqualByComparingTo(BigDecimal.valueOf(500_000));
        Assertions.assertThat(closestCombination).containsExactlyInAnyOrderElementsOf(Collections.singletonList(item1));

    }
}
