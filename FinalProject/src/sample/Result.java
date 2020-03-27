package sample;

public class Result {
    int type;
    int size;
    int ChangesBubble;
    int ComparesBubble;
    int ChangesInsertion;
    int ComparesInsertion;
    int ChangesQuick;
    int ComparesQuick;
    int ChangesMerge;
    int ComparesMerge;


    Result()
    {

    }
    Result(int type, int size, int ChB, int CoB, int ChI, int CoI, int ChQ, int CoQ, int ChM, int CoM)
    {
        this.type = type;
        this.size = size;
        this.ChangesBubble = ChB;
        this.ComparesBubble = CoB;
        this.ChangesInsertion = ChI;
        this.ComparesInsertion = CoI;
        this.ChangesQuick = ChQ;
        this.ComparesQuick = CoQ;
        this.ChangesMerge = ChM;
        this.ComparesMerge = CoM;

    }

    public String toString()
    {
        if(type == 1)
        {
            return "Random of size " + size;
        }
        if(type == 2)
        {
            return "Descending of size " + size;
        }
        if(type == 3)
        {
            return "Alternating Narrowing of size " + size;
        }
        if(type == 4)
        {
            return "Alternating Expanding of size " + size;
        }
        return "error";
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getChangesBubble() {
        return ChangesBubble;
    }

    public void setChangesBubble(int changesBubble) {
        ChangesBubble = changesBubble;
    }

    public int getComparesBubble() {
        return ComparesBubble;
    }

    public void setComparesBubble(int comparesBubble) {
        ComparesBubble = comparesBubble;
    }

    public int getChangesInsertion() {
        return ChangesInsertion;
    }

    public void setChangesInsertion(int changesInsertion) {
        ChangesInsertion = changesInsertion;
    }

    public int getComparesInsertion() {
        return ComparesInsertion;
    }

    public void setComparesInsertion(int comparesInsertion) {
        ComparesInsertion = comparesInsertion;
    }

    public int getChangesQuick() {
        return ChangesQuick;
    }

    public void setChangesQuick(int changesQuick) {
        ChangesQuick = changesQuick;
    }

    public int getComparesQuick() {
        return ComparesQuick;
    }

    public void setComparesQuick(int comparesQuick) {
        ComparesQuick = comparesQuick;
    }

    public int getChangesMerge() {
        return ChangesMerge;
    }

    public void setChangesMerge(int changesMerge) {
        ChangesMerge = changesMerge;
    }

    public int getComparesMerge() {
        return ComparesMerge;
    }

    public void setComparesMerge(int comparesMerge) {
        ComparesMerge = comparesMerge;
    }
}
