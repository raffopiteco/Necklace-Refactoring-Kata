package necklaceRefactoringKata.cof.necklace;

import necklaceRefactoringKata.JewelleryStorage;
import necklaceRefactoringKata.jewellery.Necklace;

public abstract class BaseNecklacePackerHandler implements NecklacePackerHandler {

  private NecklacePackerHandler next;

  public void setNext(NecklacePackerHandler next) {
    this.next = next;
  }

  abstract public void pack(Necklace item, JewelleryStorage storage);

  public void next(Necklace item, JewelleryStorage storage) {
    if(next != null) {
      next.packIfCan(item, storage);
    }
  }

  abstract public boolean canPack(Necklace item);
}
