 public class Account{
    private String accountName;
    private int numberOfFollowing;
    private int numberOfFollowers;
    private Account [] followers = new Account[100];
    private Account [] following = new Account[100];
    public Account (String name){
        this.accountName=name;
        this.numberOfFollowers=0;
        this.numberOfFollowing=0;


        }
    /*Methods */
    /*Getter methods */
    public String getName(){
        return this.accountName;
    }
    public int getNumberOfFollowers(){
        return this.numberOfFollowers;
    }
    public int getNumberOfFollowing(){
        return this.numberOfFollowing;
    }
    public Account getFollower(int position){
        return this.followers[position];
    }
    public Account getFollowing(int position){
        return this.following[position];
    }
    /*End of Getter methods */
    /*Setter methods */
     public void increaseFollowers(){
        this.numberOfFollowers++;
    }
    public void increaseFollowing(){
        this.numberOfFollowing++;
    }
    public void addFollower( Account placeholder){
        int i=0;
        while(this.followers[i]!=null){
            i++;
        }
        followers[i]=placeholder;
        this.increaseFollowers();
    }
    
    public void addFollowing(Account placeholder){
        int i=0;
        while(this.following[i]!=null){
            i++;
        }
        this.following[i]=placeholder;
        this.increaseFollowing();
    }
    /*End of Setter methods */

    /*End of methods */
}