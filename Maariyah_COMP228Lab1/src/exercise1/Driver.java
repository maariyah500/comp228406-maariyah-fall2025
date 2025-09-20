package exercise1;

public class Driver {

    static void main(String[] args) {
        int currentAlbums = 5;
        int moreAlbums = 8;
        Singers singer1 = new Singers();

        System.out.println("Singer 1 Default Values...");
        displaySingerDetails(singer1);

        singer1.setAllValues(
                1,
                "Maariyah Shaikh",
                "2556 178 St",
                "August 28, 1997",
                currentAlbums);

        System.out.println("\nSet All Values At Once...");
        displaySingerDetails(singer1);

        singer1.setSingerID(3);
        singer1.setSingerName("Mohammed Zakee Shaikh");
        singer1.setSingerAddress("3555 W12 St");
        singer1.setDateOfBirth("October 18, 1991");
        singer1.setAlbumsPublished(moreAlbums);

        System.out.println("\nValues After Individual Changes...");
        displaySingerDetails(singer1);
    }

    private static void displaySingerDetails(Singers singer) {
        System.out.println("Singer ID: " + singer.getSingerID());
        System.out.println("Singer Name: " + singer.getSingerName());
        System.out.println("Singer Address: " + singer.getSingerAddress());
        System.out.println("Date of Birth: " + singer.getDateOfBirth());
        System.out.println("Albums Published: " + singer.getAlbumsPublished() + "\n");
    }
}




class Singers {
    private int singerID;
    private String singerName;
    private String singerAddress;
    private String singerDOB;
    private int albumRelease;

    Singers() {
    }

    Singers(
            int id,
            String name,
            String address,
            String dob,
            int albums) {
        this.singerID = id;
        this.singerName = name;
        this.singerAddress = address;
        this.singerDOB = singerDOB;
        this.albumRelease = albums;
    }

    public int getSingerID() {
        return this.singerID;
    }

    public void setSingerID(int id) {
        this.singerID = id;
    }

    public String getSingerName() {
        return this.singerName;
    }

    public void setSingerName(String name) {
        this.singerName = name;
    }

    public String getSingerAddress() {
        return this.singerAddress;
    }

    public void setSingerAddress(String address) {
        this.singerAddress = address;
    }

    public String getDateOfBirth() {
        return this.singerDOB;
    }

    public void setDateOfBirth(String dob) {
        this.singerDOB = dob;
    }

    public int getAlbumsPublished() {
        return this.albumRelease;
    }

    public void setAlbumsPublished(int albums) {
        this.albumRelease = albums;
    }

    public void setAllValues(
            int id,
            String name,
            String address,
            String dob,
            int albums) {
        this.singerID = id;
        this.singerName = name;
        this.singerAddress = address;
        this.singerDOB = dob;
        this.albumRelease = albums;
    }
}