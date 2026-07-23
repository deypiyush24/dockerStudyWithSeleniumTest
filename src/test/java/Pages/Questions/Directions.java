package Pages.Questions;

public enum Directions {

    North("NorthPiyush"),
    South("South"),
    East("East"),
    West("West");

    private String direction;

    Directions(String direction) {
        this.direction =  direction;
    }

    public String getDirection() {
        return direction;
    }

}


class checkBaby
{

    static void main() {

        System.out.println(Directions.North.getDirection());
    }


}