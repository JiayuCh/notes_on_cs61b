public class Planet {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;
    public static final double G = 6.67e-11;

    public Planet(double xP, double yP, double xV,
                  double yV, double m, String img){
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    public Planet(Planet p){
        //this = p; not working
        xxPos = p.xxPos;
        yyPos = p.yyPos;
        xxVel = p.xxVel;
        yyVel = p.yyVel;
        mass = p.mass;
        imgFileName = p.imgFileName;
    }

    public double calcDistance(Planet n){
        double distance;
        double delta_x = this.xxPos - n.xxPos;
        double delta_y = this.yyPos - n.yyPos;
        distance = Math.sqrt(delta_x * delta_x + delta_y * delta_y);
        return distance;
    }

    public double calcForceExertedBy(Planet n){
        double force = G * this.mass * n.mass / (this.calcDistance(n) * this.calcDistance(n));
        return force;
    }

    public double calcForceExertedByX(Planet n){
        double force_x = this.calcForceExertedBy(n) * (n.xxPos - this.xxPos) / this.calcDistance(n);
        return force_x;
    }

    public double calcForceExertedByY(Planet n){
        double force_x = this.calcForceExertedBy(n) * (n.yyPos - this.yyPos) / this.calcDistance(n);
        return force_x;
    }

    public double calcNetForceExertedByX(Planet[] n){
        double netForce_x = 0;
        for (Planet body:n){
            if(!this.equals(body)){
                netForce_x += this.calcForceExertedByX(body);
            }
        }
        return netForce_x;
    }

    public double calcNetForceExertedByY(Planet[] n){
        double netForce_y = 0;
        for (Planet body:n){
            if(!this.equals(body)){
                netForce_y += this.calcForceExertedByY(body);
            }
        }
        return netForce_y;
    }

    public void update(double dt, double force_x, double force_y){
        double acc_x = force_x / this.mass;
        double acc_y = force_y / this.mass;
        this.xxVel = acc_x * dt + xxVel;
        this.yyVel = acc_y * dt + yyVel;
        this.xxPos += this.xxVel * dt;
        this.yyPos += this.yyVel * dt;
    }

    public void draw(){
        StdDraw.picture(xxPos, yyPos, "images/" + imgFileName);
    }
}
