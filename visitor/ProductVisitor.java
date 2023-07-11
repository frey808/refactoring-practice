public interface ProductVisitor {
    public double visit(Product p);
    public String visitString(Product p);
}