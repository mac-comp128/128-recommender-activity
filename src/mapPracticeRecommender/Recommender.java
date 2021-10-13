package mapPracticeRecommender;
import java.util.*;

import mapPracticeRecommender.Student;

/**
 * Created by bjackson on 11/17/2015.
 */
public class Recommender {

    //TODO: Declare the two data structures to hold the information need for the following features:
    // Given a user, it can produce the list of movies that they like.
    // Given a movie, it can produce a list of users that like the movie.


    public Recommender() {
        //TODO: initialize the data structures

    }

    /**
     * Adds the movieTitle to a list of movies that the student likes.
     * Also adds the student to the list of students who like this movieTitle.
     *
     * @param student the person who likes the movie
     * @param movieTitle  the title of the movie that the person likes
     */
    public void addLike(Student student, String movieTitle){
        //TODO: complete the method

    }

    /**
     * Returns a List of movie titles that the given student likes
     * @param student Student object who may have movies they like
     * @return a List of movie titles that the given student likes or null
     *         if the student likes no movies
     */
    List<String> movieLikes(Student student) {
        //TODO: Complete this method

    }

    /**
     * Returns a List of Students who like a given movie
     * @param movie the movie title
     * @return a List of Students who like a given movie or null
     *         if no Student has yet liked that movie
     */
    List<Student> whoLikes(String movie) {
        //TODO: Complete this method

    }

    /**
     * Provide a List of movie title recommendations for a given student.
     * If the student does not like any movies yet, then return an empty List.
     *
     * @param student
     * @return a List of movie titles as recommendations or an empty List.
     */
    public List<String> recommend(Student student){
        List<String> likes = movieLikes(student);

        // We can't make recommendations if we don't know the person
        // or have any movies that they like.
        if (likes == null){
            return new LinkedList<>();
        }

        List<String> results = new ArrayList<>();
        for(String movie : likes){
            // find other people who liked the same movie.
            List<Student> similarStudents = whoLikes(movie);

            for(Student s : similarStudents){ // for each student who liked the movie
                if (s != student){
                    List<String> curLikes = movieLikes(s);  // find the other movies the other student likes
                    for(String otherMovie : curLikes){ // for each of these other movies
                        // add to recommendations as long as:
                        //      the other movie is not this movie
                        //      the other movie is not already liked by this student
                        //      the other movie isn't already recommended
                        if (!otherMovie.equals(movie) && !likes.contains(otherMovie) && !results.contains(otherMovie)) {
                                results.add(otherMovie);
                        }
                    }
                }
            }
        }
        return results;
    }

    public void printRecommendationList(Student s){
        List<String> recommendations = recommend(s);
        System.out.println("Recommendations for: "+s.getName());
        for(String str : recommendations){
            System.out.println("\t"+str);
        }
    }

    public static void main(String[] args) {
        Recommender rec = new Recommender();
        Student s1 = new Student("s1", 1);
        Student s2 = new Student("s2", 2);
        Student s3 = new Student("s3", 3);
        Student s4 = new Student("s4", 4);

        rec.addLike(s1, "Matrix");
        rec.addLike(s1, "Star Wars");
        rec.addLike(s1, "Bourne Identity");

        rec.addLike(s2, "Star Wars");
        rec.addLike(s2, "Casablanca");

        rec.addLike(s3, "Bourne Identity");
        rec.addLike(s3, "Goldfinger");
        rec.addLike(s3, "Ratatouille");

        rec.addLike(s4, "Toy Story");
        rec.addLike(s4, "Ratatouille");

        rec.printRecommendationList(s1);
        rec.printRecommendationList(s2);
        rec.printRecommendationList(s3);
        rec.printRecommendationList(s4);
    }
}
