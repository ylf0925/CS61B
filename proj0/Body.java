

public class Body {

    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;

    public Body(double xP, double yP, double xV, double yV,
                double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    public Body(Body b) {
        this.xxPos = b.xxPos;
        this.yyPos = b.yyPos;
        this.xxVel = b.xxVel;
        this.yyVel = b.yyVel;
        this.mass = b.mass;
        this.imgFileName = b.imgFileName;
    }

    public double calcDistance(Body b) {
        double dx = b.xxPos - this.xxPos;
        double dy = b.yyPos - this.yyPos;
        return Math.hypot(dx, dy);

    }

    public double calcForceExertedBy(Body b) {
        final double G = 6.67e-11;
        double up = (this.mass * b.mass * G);
        return up / Math.pow(calcDistance(b), 2);
    }

    public double calcForceExertedByX(Body b) {
        double dx = b.xxPos - this.xxPos;
        double cosAlpha = dx / calcDistance(b);
        return cosAlpha * calcForceExertedBy(b);
    }

    public double calcForceExertedByY(Body b) {
        double dy = b.yyPos - this.yyPos;
        double sinAlpha = dy / calcDistance(b);
        return sinAlpha * calcForceExertedBy(b);
    }

    public double calcNetForceExertedByX(Body[] ary) {
        double xxSum = 0;
        Body curr = this;
        for (Body item : ary) {
            if (!item.equals(curr)) {
                xxSum += curr.calcForceExertedByX(item);
            }
        }
        return xxSum;
    }

    public double calcNetForceExertedByY(Body[] ary) {
        double yySum = 0;
        Body curr = this;
        for (Body item : ary) {
            if (!item.equals(curr)) {
                yySum += curr.calcForceExertedByY(item);
            }
        }
        return yySum;
    }

    public void update(double dt, double xxForce, double yyForce) {
        double xxAcc = xxForce / this.mass;
        double yyAcc = yyForce / this.mass;
        this.xxVel = this.xxVel + dt * xxAcc;
        this.yyVel = this.yyVel + dt * yyAcc;
        this.xxPos = this.xxPos + dt * this.xxVel;
        this.yyPos = this.yyPos + dt * this.yyVel;
    }

    public void draw() {
        StdDraw.picture(this.xxPos, this.yyPos, "images/" + this.imgFileName);
    }
}