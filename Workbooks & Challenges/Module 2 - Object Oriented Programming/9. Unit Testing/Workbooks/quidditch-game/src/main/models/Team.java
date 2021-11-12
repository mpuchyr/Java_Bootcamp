package src.main.models;

import java.util.Arrays;
import java.util.Objects;

public class Team {

    private static final String POSITION_CHASER = "chaser";
    private static final String POSITION_SEEKER = "seeker";
    private static final String POSITION_KEEPER = "keeper";

    private String house;
    private String keeper;
    private String seeker;
    private String[] chasers;


    public Team(String house, String keeper, String seeker, String[] chasers) {
        // if (house == null || house.isBlank()) {
        //     throw new IllegalArgumentException("House cannot be blank or null");
        // }
        checkParam(house);


        // if (keeper == null || keeper.isBlank()) {
        //     throw new IllegalArgumentException("Keeper cannot be blank or null");
        // }
        checkParam(keeper);

        // if (seeker == null || seeker.isBlank()) {
        //     throw new IllegalArgumentException("Seeker cannot be blank or null");
        // }
        checkParam(seeker);

        if (chasers == null) {
            throw new IllegalArgumentException("Chasers cannot be null");
        }

        if (chasers.length < 3) {
            throw new IllegalArgumentException("Chasers length cannot be less than 3");
        }

        if (hasBlank(chasers) || hasNull(chasers)) {
            throw new IllegalArgumentException("Chasers array cannot contain a null or blank value");
        }
        
        this.house = house;
        this.keeper = keeper;
        this.seeker = seeker;
        this.chasers = Arrays.copyOf(chasers, chasers.length);
    }

    public Team(Team source) {
        this.house = source.house;
        this.keeper = source.keeper;
        this.seeker = source.seeker;
        this.chasers = Arrays.copyOf(source.chasers, source.chasers.length);
    }

    public String getHouse() {
        return this.house;
    }

    public String getKeeper() {
        return this.keeper;
    }

    public String getSeeker() {
        return this.seeker;
    }

    public String[] getChasers() {
        return Arrays.copyOf(this.chasers, this.chasers.length);
    }

    public void setHouse(String house) {
        checkParam(house);
        this.house = house;
    }

    public void setKeeper(String keeper) {
        checkParam(keeper);
        this.keeper = keeper;
    }

    public void setSeeker(String seeker) {
        checkParam(seeker);
        this.seeker = seeker;
    }

    public void setChasers(String[] chasers) {
        this.chasers = Arrays.copyOf(chasers, chasers.length);
    }

    public String toString() {
        return "House: " + this.house + "\n" +
          "Keeper: " + this.keeper + "\n" +         
          "Seeker: "  + this.seeker + "\n" +         
          "Chasers: " + Arrays.toString(this.chasers) + "\n"; 
    }

    public void checkParam(String param) {
        if (param == null || param.isBlank()) {
            throw new IllegalArgumentException(param + " cannot be null/blank");
        }
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (!(obj instanceof Team)) {
            return false;
        }

        Team team = (Team)obj;
        return this.house.equals(team.house)
            && this.keeper.equals(team.keeper)
            && this.seeker.equals(team.seeker)
            && Arrays.toString(this.chasers).equals(Arrays.toString(team.chasers));
    }

    public int hashCode() {
        return Objects.hash(house, keeper, seeker, Arrays.toString(chasers));
    }
    
     public static String getPositionChaser() {
         return POSITION_CHASER;
     }

     public static String getPositionSeeker() {
         return POSITION_SEEKER;
     }

     public static String getPositionKeeper() {
         return POSITION_KEEPER;
     }

     public static boolean hasNull(String[] array) {
        return Arrays.stream(array)
            .anyMatch((item) -> item == null);
     }

     public static boolean hasBlank(String[] array) {
         return Arrays.stream(array)
            .anyMatch((item -> item.isBlank()));
     }



}
