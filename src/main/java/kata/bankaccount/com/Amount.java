package kata.bankaccount.com;

public class Amount {

        private int value;

        public Amount(int value) {
            if (value < 0)
                throw new IllegalArgumentException();
            this.value = value;
        }

        public Amount add(Amount amount) {
            return new Amount(this.value + amount.value);
        }

        public Amount subtract(Amount amount) {
            return new Amount(this.value - amount.value);
        }

        @Override
        public String toString() {
            return "" + value;
        }

       @Override
        public boolean equals(Object o) {
    	   // Check if it is the same object
            if (this == o) {
            	return true;
            }
            // check if it is an instance of Amount or one of its subclasses. It return false if o is null
            if (!(o instanceof Amount)) {
            	return false;
            }

            Amount amount = (Amount) o;
            return value == amount.value;
        }

        boolean canWithdraw(Amount amount) {
            return this.value - amount.value >= 0;
        }
}
