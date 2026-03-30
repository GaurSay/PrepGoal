package Concurrency;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class State {
    private PrintType nextToPrint;

}
