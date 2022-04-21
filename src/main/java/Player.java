public class Player {
    private String name;
    private String email;
    private boolean white;
    private int rank;
    private int age;

    public Player(String name, String email, boolean white, int rank, int age) {
        if (name == null || name.isBlank() || name.isEmpty()) {
            throw new IllegalArgumentException("name can't be empty");
        } else {
            this.name = name;
        }

        if (email == null || email.isEmpty() || email.isBlank()) {
            throw new IllegalArgumentException("email can't be empty");
        }
        if (!email.contains("@") || !email.contains(".")) {
            throw new IllegalArgumentException("the email address should contain '@' and '.'");
        } else {
            this.email = email;
        }
        this.white = white;
        this.rank = rank;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isWhite() {
        return white;
    }

    public void setWhite(boolean white) {
        this.white = white;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        if (rank < 100 || rank > 3000) {
            throw new IllegalArgumentException("such rang doesn't exists");
        }
        this.rank = rank;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {

        this.age = age;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", white=" + white +
                ", rank=" + rank +
                ", age=" + age +
                '}';
    }


    public void movePiece(Piece piece, Spot spot) {
        if (piece.isWhite() != isWhite()) {
            throw new IllegalArgumentException("incorrect piece color");
        }
        piece.setSpot(spot);
        System.out.println("Figure " + piece.getName() + " moved " + spot);
    }


}

