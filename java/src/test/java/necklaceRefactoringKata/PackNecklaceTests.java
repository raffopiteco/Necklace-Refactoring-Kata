package necklaceRefactoringKata;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Collection;
import necklaceRefactoringKata.jewellery.Jewel;
import necklaceRefactoringKata.jewellery.Necklace;
import necklaceRefactoringKata.jewellery.NecklaceType;
import necklaceRefactoringKata.jewellery.Pendant;
import necklaceRefactoringKata.jewellery.PendantNecklace;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;

class PackNecklaceTests {

    private static Collection<Necklace> packNecklace_notHeavy_storeInBoxTopShelf() {
        var necklaces = new ArrayList<Necklace>();
        for (var jewel: Jewel.values()) {
            if (jewel != Jewel.Diamond) {
                for (var necklaceType: NecklaceType.values()) {
                    if (necklaceType != NecklaceType.Beads && necklaceType != NecklaceType.LongChain) {
                        necklaces.add(new Necklace(jewel, necklaceType));
                    }
                }
            }
        }
        return necklaces;
    }

    private static Collection<Necklace> packNecklace_ofTypePendantNecklaceAndHeavy_storeChainInTheTreeAndPendantInTheBoxTopShelf() {
        var necklaces = new ArrayList<Necklace>();
        for (var jewel: Jewel.values()) {
            if (jewel != Jewel.Diamond) {
                necklaces.add(new PendantNecklace(new Necklace(jewel, NecklaceType.Beads), new Pendant(jewel)));
                necklaces.add(new PendantNecklace(new Necklace(jewel, NecklaceType.LongChain), new Pendant(jewel)));
                for (var necklaceType: NecklaceType.values()) {
                    if (necklaceType != NecklaceType.Beads && necklaceType != NecklaceType.LongChain) {
                        necklaces.add(new PendantNecklace(new Necklace(jewel, necklaceType), new Necklace(jewel, NecklaceType.Beads)));
                        necklaces.add(new PendantNecklace(new Necklace(jewel, necklaceType), new Necklace(jewel, NecklaceType.LongChain)));
                    }
                }
            }
        }
        return necklaces;
    }

    private static Collection<Necklace> packNecklace_isNotDiamondAndIsHeavyAndIsNotPendantNecklace_storeInTheTree() {
        var necklaces = new ArrayList<Necklace>();
        for (var jewel: Jewel.values()) {
            if (jewel != Jewel.Diamond) {
                necklaces.add(new Necklace(jewel, NecklaceType.Beads));
                necklaces.add(new Necklace(jewel, NecklaceType.LongChain));
            }
        }
        return necklaces;
    }

    @ParameterizedTest
    @EnumSource(NecklaceType.class)
    void packNecklace_withDiamond_storeInSafe(NecklaceType type) {
        var storage = new JewelleryStorage();

        var item = new Necklace(Jewel.Diamond, type);
        Packer.packNecklace(item, storage);

        assertThat(storage.safe).hasSize(1);
        assertThat(storage.tree).isEmpty();
        assertThat(storage.travelRoll).isEmpty();
        assertThat(storage.box.ringCompartment).isEmpty();
        assertThat(storage.box.topShelf).isEmpty();
        assertThat(storage.box.mainSection).isEmpty();
    }

    @ParameterizedTest
    @MethodSource
    void packNecklace_notHeavy_storeInBoxTopShelf(Necklace notHeavyNecklace) {
        var storage = new JewelleryStorage();

        Packer.packNecklace(notHeavyNecklace, storage);

        assertThat(storage.safe).isEmpty();
        assertThat(storage.tree).isEmpty();
        assertThat(storage.travelRoll).isEmpty();
        assertThat(storage.box.ringCompartment).isEmpty();
        assertThat(storage.box.topShelf).hasSize(1);
        assertThat(storage.box.mainSection).isEmpty();
    }

    @ParameterizedTest
    @MethodSource
    void packNecklace_ofTypePendantNecklaceAndHeavy_storeChainInTheTreeAndPendantInTheBoxTopShelf(Necklace notHeavyNecklace) {
        var storage = new JewelleryStorage();

        Packer.packNecklace(notHeavyNecklace, storage);

        assertThat(storage.safe).isEmpty();
        assertThat(storage.tree).hasSize(1);
        assertThat(storage.travelRoll).isEmpty();
        assertThat(storage.box.ringCompartment).isEmpty();
        assertThat(storage.box.topShelf).hasSize(1);
        assertThat(storage.box.mainSection).isEmpty();
    }

    @ParameterizedTest
    @MethodSource
    void packNecklace_isNotDiamondAndIsHeavyAndIsNotPendantNecklace_storeInTheTree(Necklace notHeavyNecklace) {
        var storage = new JewelleryStorage();

        Packer.packNecklace(notHeavyNecklace, storage);

        assertThat(storage.safe).isEmpty();
        assertThat(storage.tree).hasSize(1);
        assertThat(storage.travelRoll).isEmpty();
        assertThat(storage.box.ringCompartment).isEmpty();
        assertThat(storage.box.topShelf).isEmpty();
        assertThat(storage.box.mainSection).isEmpty();
    }
}
