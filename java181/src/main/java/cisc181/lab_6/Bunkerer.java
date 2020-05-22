package cisc181.lab_6;


// Interface for pieces that can bunker
public interface Bunkerer {
    public abstract void toggleBunker(int firstSpaceRow, int firstSpaceCol,
                                int secondSpaceRow, int secondSpaceCol);
}
