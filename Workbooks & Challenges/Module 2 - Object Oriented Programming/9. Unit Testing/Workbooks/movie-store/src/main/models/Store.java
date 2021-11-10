package src.main.models;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class Store {
    ArrayList<Movie> movies;

    public Store() {
        this.movies = new ArrayList<Movie>();
    }

    public Movie getMovie(int index) {
        return new Movie(this.movies.get(index));
    }

    public void setMovie(int index, Movie movie) {
        this.movies.set(index, new Movie(movie));
    }

    public int getSize() {
        return this.movies.size();
    }

    public void addMovie(Movie movie) {
        this.movies.add(new Movie(movie));
    }

    public boolean contains(Movie movie) {
        return this.movies.contains(movie);
    }

    public void sellMovie(Movie movie){
        int movieIndex = getMovieIndex(movie.getName());
        if (!this.movies.get(movieIndex).isAvailable()) {
            throw new IllegalStateException("Movie is not in stock");
        }
        this.movies.removeIf((element) -> element.equals(movie));
    }

    public void rentMovie(String name) {
        int movieIndex = getMovieIndex(name);
        this.movies.get(movieIndex).setAvailable(false);
    }

    public void returnMovie(String name) {
        int movieIndex = getMovieIndex(name);
        this.movies.get(movieIndex).setAvailable(true);
    }

    public int getMovieIndex(String name) {

        return IntStream.range(0, this.movies.size())
            .filter(index -> movies.get(index).getName().equals(name))
            .findFirst()
            .orElse(-1000);

    }

    public String toString() {
        String temp = "";
        for (int i = 0; i < this.movies.size(); i++) {
            temp += this.movies.get(i).toString();
            temp += "\n\n";
        }
        return temp;
    }

}
