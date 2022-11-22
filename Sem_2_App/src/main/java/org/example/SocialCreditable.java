package org.example;

import java.util.function.Predicate;

public interface SocialCreditable {
     int getSocialCredits();
     void giveSocialCredits(Predicate<Programmer> predicate, int amount);
}
