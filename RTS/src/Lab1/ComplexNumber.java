package Lab1;

public class ComplexNumber {
    private double real;
    private double imag;

    public ComplexNumber(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    public ComplexNumber add(ComplexNumber other) {
        double newReal = this.real + other.real;
        double newImag = this.imag + other.imag;
        return new ComplexNumber(newReal, newImag);
    }

    public ComplexNumber multiply(ComplexNumber other) {
        double newReal = (this.real * other.real) + (this.imag * other.imag);
        double newImag = (this.imag * other.real) + (this.real * other.imag);
        return new ComplexNumber(newReal, newImag);
    }

    public String toString() {
        return String.format("%.2f + %.2fi", real, imag);
    }

    public static void main(String[] args) {
        ComplexNumber num1 = new ComplexNumber(2, 5);
        ComplexNumber num2 = new ComplexNumber(4, -1);

        ComplexNumber sum = num1.add(num2);
        ComplexNumber product = num1.multiply(num2);

        System.out.println("First number: " + num1);
        System.out.println("Second number: " + num2);
        System.out.println("Sum: " + sum);
        System.out.println("Product: " + product);
    }
}