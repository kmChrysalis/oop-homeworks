public class Rooter {
	private double precision;

	public Rooter(double precision) { //constructer for rooter
		this.setPrecision(precision);
	}

	public void setPrecision(double precision) { //setter for precision
		this.precision = precision;
	}

	public double sqrt(double x) { //sqrt function
		double one = x / 2;
		double two = x / one;
		while (one != two)	{	//repeat while one not equal two
			if (Math.abs(one - two) < precision) //check if difference between one and two less than precision
				return one; //return one or two if true
			else	{ //repeat with new numbers by the algorithm
				one = (one + two) / 2;
				two = x / one;
			}
		}
		return one;
	}
}