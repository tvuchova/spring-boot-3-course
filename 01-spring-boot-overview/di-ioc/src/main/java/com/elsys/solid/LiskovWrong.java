package com.elsys.solid;

public class LiskovWrong {
    public static void main(String[] args) {

        Rectangle rectangle = new Rectangle();
        resizeRectangle(rectangle); //ok

        Rectangle square = new Square(); // Substituting Square for Rectangle
        resizeRectangle(square); // Violates LSP

    }

    static class Rectangle {
        protected int width;
        protected int height;

        public void setWidth(int width) {
            this.width = width;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public int getWidth() {
            return width;
        }

        public int getHeight() {
            return height;
        }

        public int getArea() {
            return width * height;
        }
    }

    static class Square extends Rectangle {
        @Override
        public void setWidth(int width) {
            this.width = width;
            this.height = width; // Ensure both sides are equal
        }

        @Override
        public void setHeight(int height) {
            this.width = height; // Ensure both sides are equal
            this.height = height;
        }
    }

    public static void resizeRectangle(Rectangle rectangle) {
        rectangle.setWidth(5);
        rectangle.setHeight(10);

        System.out.println("Expected Area: 50");
        System.out.println("Actual Area: " + rectangle.getArea());
    }

}

