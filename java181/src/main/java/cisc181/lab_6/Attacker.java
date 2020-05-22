package cisc181.lab_6;

// Interface for attacking pieces
public interface Attacker {
    public abstract void attack(int firstSpaceRow, int firstSpaceCol,
                                int secondSpaceRow, int secondSpaceCol);
}
