package necklaceRefactoringKata.cof.necklace;

import necklaceRefactoringKata.JewelleryStorage;
import necklaceRefactoringKata.jewellery.Jewel;
import necklaceRefactoringKata.jewellery.Necklace;

public class DiamondNecklacePackerHandler extends BaseNecklacePackerHandler {

  public void pack(Necklace item, JewelleryStorage storage) {
    storage.safe.add(item);
  }

  public boolean canPack(Necklace item) {
    return item.stone == Jewel.Diamond;
  }
}
