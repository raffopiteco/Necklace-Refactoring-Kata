package necklaceRefactoringKata.cof.necklace;

import necklaceRefactoringKata.JewelleryStorage;
import necklaceRefactoringKata.jewellery.Necklace;

public class DefaultNecklacePackerHandler extends BaseNecklacePackerHandler {

  public void pack(Necklace item, JewelleryStorage storage) {
    storage.tree.add(item);
  }

  public boolean canPack(Necklace item) {
    return true;
  }
}
