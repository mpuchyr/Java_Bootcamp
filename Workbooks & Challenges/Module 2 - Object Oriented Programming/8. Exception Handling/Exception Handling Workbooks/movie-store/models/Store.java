package models;

import java.util.ArrayList;

public class Store {
    ArrayList<Movie> movies;

    public Store() {
        this.movies = new ArrayList<Movie>();
    }

    public Movie getMovie(int index) {
        return movies.get(index);
    }

    public Movie getMovie (String name) {
        for (int i = 0; i < movies.size(); i++) {
            if (movies.get(i).getName().equals(name)) {
                return movies.get(i);
            }
        }
        return null;
    }

    public void setMovie(int index, Movie movie) {
        movies.set(0, new Movie(movie));
    }

    public void addMovie(Movie movie) {
        movies.add(new Movie(movie));
    }

    public void action(String name, String action) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null/blank");
        }
        if (!(action.equals("sell") || action.equals("rent") || action.equals("return"))) {
            throw new IllegalArgumentException("The only valid actions are sell, rent, and return");
        }
        if (movies.isEmpty()) {
            throw new IllegalStateException("there are no movies");
        }
        for (int i = 0; i < movies.size(); i++) {
            if (movies.get(i).getName().equals(name)) {
                if (action.equals("sell")) {
                    if (!movies.get(i).isAvailable()) {
                        throw new IllegalStateException("cannot sell a movie that has been rented");
                    }
                    movies.remove(i);
                    break;
                } else if (action.equals("rent")) {
                    movies.get(i).setIsAvailable(false);
                    break;
                } else {
                    movies.get(i).setIsAvailable(true);
                    break;
                }
            }
        }
    }

    public String toString() {
        String temp = "";
        
        for (int i = 0; i < movies.size(); i++) {
            temp += movies.get(i).toString() + "\n\n";
        }
        
        return temp;
    }
}
