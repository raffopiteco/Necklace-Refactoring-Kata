package necklaceRefactoringKata.cof.necklace;

import necklaceRefactoringKata.JewelleryStorage;
import necklaceRefactoringKata.jewellery.Necklace;

public class LightNecklacePackerHandler extends BaseNecklacePackerHandler {

  public void pack(Necklace item, JewelleryStorage storage) {
    storage.box.topShelf.add(item);
  }

  public boolean canPack(Necklace item) {
    return !item.isHeavy();
  }
}
