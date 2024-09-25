package necklaceRefactoringKata;


import necklaceRefactoringKata.jewellery.Jewel;
import necklaceRefactoringKata.jewellery.Necklace;
import necklaceRefactoringKata.jewellery.NecklaceType;
import necklaceRefactoringKata.jewellery.Pendant;
import necklaceRefactoringKata.jewellery.PendantNecklace;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class PackNecklaceTests {

    @Test
    void test_pack_pearl_necklace() {
        var item = new Necklace(Jewel.Pearl, NecklaceType.Beads);
        var storage = new JewelleryStorage();
        Packer.packNecklace(item, storage);
        // TODO: check it packed it correctly
    }

    @Disabled("new feature")
    @Test
    void test_pack_diamond_pendant_necklace() {
        var item = new PendantNecklace(new Necklace(Jewel.Plain, NecklaceType.Chain), new Pendant(Jewel.Diamond));
        var storage = new JewelleryStorage();
        Packer.packNecklace(item, storage);
        // TODO: check it packed it correctly
    }
}
