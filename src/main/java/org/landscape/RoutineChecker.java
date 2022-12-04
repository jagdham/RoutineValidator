package org.landscape;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class RoutineChecker {
    @NonNull
    private Routine initial;
    @NonNull
    private Routine adjustment;
    @NonNull
    private Routine finalBill;

    private static final int BackwardRoutine = 99;
    private static final int IncrementAmountCode = 11;
    private static final int DecrementAmountCode = 22;
    private static final int NoChangeCode = 3;

    public int validate() {
        log.info("initialAmount: {} adjustmentAmount: {} finalAmount: {}", initial.getAmount(), adjustment.getAmount(), finalBill.getAmount());
        if (initial.getDate().compareTo(adjustment.getDate()) > 0 || adjustment.getDate().compareTo(finalBill.getDate()) > 0 ) {
            return BackwardRoutine;
        }

        if (initial.getAmount() > finalBill.getAmount()){
            return DecrementAmountCode;
        } else if (initial.getAmount() < finalBill.getAmount()) {
            return IncrementAmountCode;
        }
        return NoChangeCode;
    }
}
