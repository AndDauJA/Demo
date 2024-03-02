package com.mtb.demo.integration.domain;

import com.mtb.demo.integration.common.domain.IntegrationApi;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class BigCommerceApi implements IntegrationApi {

    private final List<BigCommerceClients> clients = new ArrayList<>();

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("====> Integration of BigCommerceApi{");
        sb.append("clients=").append(clients);
        sb.append('}');
        return sb.toString();
    }
}
