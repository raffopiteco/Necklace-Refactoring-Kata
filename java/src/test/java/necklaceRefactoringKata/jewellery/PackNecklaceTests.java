package necklaceRefactoringKata.jewellery;

import necklaceRefactoringKata.JewelleryStorage;
import necklaceRefactoringKata.Packer;
import org.approvaltests.Approvals;
import org.junit.jupiter.api.Test;

class PackNecklaceTests {
    private JewelleryStorage storage = new JewelleryStorage();

    String PackItem(Necklace item, JewelleryStorage storage) {
        var log = "Packing item " + item;
        if (storage.IsInTravelRoll(item))
            log += " (is in travel roll)";
        Packer.packNecklace(item, storage);
        log += "\n";
        log += Printers.PrintJewelleryStorage(storage);
        return log;
    }

    @Test
    public void PackPearlNecklace() {
        var item = new Necklace(Jewel.Pearl, NecklaceType.Beads);;
        Approvals.verify(PackItem(item, storage));
    }

    @Test
    public void PackAmberNecklace() {
        var item = new Necklace(Jewel.Amber, NecklaceType.Beads);;
        Approvals.verify(PackItem(item, storage));
    }

    @Test
    public void PackAmberChainNecklace() {
        var item = new Necklace(Jewel.Amber, NecklaceType.Chain);;
        Approvals.verify(PackItem(item, storage));
    }

    @Test
    public void PackDiamondNecklace() {
        var item = new Necklace(Jewel.Diamond, NecklaceType.Chain);;
        Approvals.verify(PackItem(item, storage));
    }

    @Test
    public void PackChain() {
        var item = new Necklace(Jewel.Plain, NecklaceType.Chain);;
        Approvals.verify(PackItem(item, storage));
    }

    @Test
    public void PackLongChain() {
        var item = new Necklace(Jewel.Plain, NecklaceType.LongChain);;
        Approvals.verify(PackItem(item, storage));
    }


    @Test
    public void PackPendantNecklace() {
        var item = new PendantNecklace(
                new Necklace(Jewel.Plain, NecklaceType.Chain),
                new Pendant(Jewel.Amber));
        Approvals.verify(PackItem(item, storage));
    }

    @Test
    public void PackPendantNecklaceLongChain() {
        var item = new PendantNecklace(
                new Necklace(Jewel.Plain, NecklaceType.LongChain),
                new Pendant(Jewel.Amber));
        Approvals.verify(PackItem(item, storage));
    }
}
