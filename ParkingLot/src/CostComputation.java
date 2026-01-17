public class CostComputation {
    PricingStrategy pricing_strategy;
    CostComputation(PricingStrategy pricing_strategy) {
        this.pricing_strategy  = pricing_strategy;
    }

    long price(Ticket ticket) {
        return this.pricing_strategy.price(ticket);
    }
}


class TwoWheelerCostComputation extends CostComputation{
    TwoWheelerCostComputation() {
        super(new HourlyBasedPricingStrategy());
    }
}

class FourWheelerCostComputation extends CostComputation{
    FourWheelerCostComputation() {
        super(new MinuteBasedPricingStrategy());
    }
}

class CostComputationFactory {
    CostComputation getCostComputation(VehicleType vt) {
        CostComputation cc = switch (vt) {
            case TwoWheeler -> new TwoWheelerCostComputation();
            default -> new FourWheelerCostComputation();
        };

        return cc;
    }
}

