package Heroes_Villains.cities;

import Heroes_Villains.Game;

import java.awt.*;

public class Citys {

    public int noOfCities;
    public Game game;
    public City[] cities;

    public Citys(Game game) {
        this.game = game;
        noOfCities = game.noOfCities;
        cities = new City[game.noOfCities];
        init();
    }

    public void init() {
        for(int x=0; x < noOfCities; x++) {
             City tempCity = new City(x, game);
             cities[x] = tempCity;
        }
    }

    public void update() {
        cities[game.getPlayer().currentCity].update();
    }

    public void render(Graphics graphics) {
        cities[game.getPlayer().currentCity].render(graphics);
    }
}
