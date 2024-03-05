package com.mtb.demo.common.type;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum CurrencyType {
    USD("$"),
    EUR("€"),
    GBP("£")
    // Add more currency types here
    ;

    private final String symbol;
}
