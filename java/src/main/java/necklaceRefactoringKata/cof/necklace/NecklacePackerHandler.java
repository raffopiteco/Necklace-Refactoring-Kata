package necklaceRefactoringKata.cof.necklace;

import necklaceRefactoringKata.JewelleryStorage;
import necklaceRefactoringKata.jewellery.Necklace;

public interface NecklacePackerHandler {

  void setNext(NecklacePackerHandler next);

  default void packIfCan(Necklace item, JewelleryStorage storage) {
    if(canPack(item)) {
      pack(item, storage);
    } else {
      next(item, storage);
    }
  }

  void pack(Necklace item, JewelleryStorage storage);

  void next(Necklace item, JewelleryStorage storage);

  boolean canPack(Necklace item);
}
