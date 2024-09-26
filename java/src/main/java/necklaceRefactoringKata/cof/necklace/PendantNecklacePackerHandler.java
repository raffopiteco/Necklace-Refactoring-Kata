package necklaceRefactoringKata.cof.necklace;

import necklaceRefactoringKata.JewelleryStorage;
import necklaceRefactoringKata.jewellery.Necklace;
import necklaceRefactoringKata.jewellery.PendantNecklace;

public class PendantNecklacePackerHandler extends BaseNecklacePackerHandler {

  public void pack(Necklace item, JewelleryStorage storage) {
    PendantNecklace pendantNecklace = (PendantNecklace) item;
    storage.tree.add(pendantNecklace.chain);
    storage.box.topShelf.add(pendantNecklace.pendant);
  }

  public boolean canPack(Necklace item) {
    return item instanceof PendantNecklace;
  }
}
