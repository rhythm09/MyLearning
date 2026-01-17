public class PricingStrategy {
    long price(Ticket ticket) {
        return 100;
    }
}


class MinuteBasedPricingStrategy extends PricingStrategy {
    @Override
    long price(Ticket ticket) {
        long diff = System.currentTimeMillis() - ticket.entry_time;
        return diff * 10 * 100;
    }
}

class HourlyBasedPricingStrategy extends PricingStrategy {
    @Override
    long price(Ticket ticket) {
        long diff = System.currentTimeMillis() - ticket.entry_time;
        return diff * 5 * 100;
    }
}