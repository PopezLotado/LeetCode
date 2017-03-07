package medium;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class T355 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Twitter twitter = new Twitter();

		// User 1 posts a new tweet (id = 5).
		twitter.postTweet(1, 5);

		// User 1's news feed should return a list with 1 tweet id -> [5].
		twitter.getNewsFeed(1);

		// User 1 follows user 2.
		twitter.follow(1, 2);

		// User 2 posts a new tweet (id = 6).
		twitter.postTweet(2, 6);

		// User 1's news feed should return a list with 2 tweet ids -> [6, 5].
		// Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
		twitter.getNewsFeed(1);

		// User 1 unfollows user 2.
		twitter.unfollow(1, 2);

		// User 1's news feed should return a list with 1 tweet id -> [5],
		// since user 1 is no longer following user 2.
		twitter.getNewsFeed(1);
	}

}
class User{
	int userid;
	List<Twitt> mys;
	LinkedList<Twitt> news;
	List<User> followed;
	public User(int userid){
		this.userid=userid;
		news=new LinkedList<Twitt>();
		followed=new ArrayList<User>();
		mys=new ArrayList<Twitt>();
	}
	public void updateNews(Twitt twitt){
		news.add(0, twitt);
	}
	public void postTweet(Twitt twitt){
		mys.add(twitt);
		news.add(0, twitt);
		for (User f : followed) {
			f.updateNews(twitt);
		}
	}
}
class Twitt{
	int tweetId;
	long time;
	public Twitt(int tweetId,long time){
		this.tweetId=tweetId;
		this.time=time;
	}
}
class Twitter {

	Map<Integer, User> users;
	long time;
    /** Initialize your data structure here. */
    public Twitter() {
        users=new HashMap<Integer, User>();
        time=0;
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
    	User user;
        if(!users.containsKey(userId)){
        	user=new User(userId);
        	users.put(userId, user);
        }else
        	user=users.get(userId);
        user.postTweet(new Twitt(tweetId, time));
        time++;
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
    	User user=users.get(userId);
    	if(user==null){
    		user=new User(userId);
        	users.put(userId, user);
    	}
    	List<Twitt> twitts=user.news.size()>10?user.news.subList(0, 10):user.news;
        List<Integer> res=new ArrayList<Integer>();
        for (Twitt t : twitts) {
			res.add(t.tweetId);
		}
        return res;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
    	if(followerId==followeeId)
    		return;
    	User followed=users.get(followeeId);
    	if(followed==null){
    		followed=new User(followeeId);
        	users.put(followeeId, followed);
    	}
    	User follower=users.get(followerId);
    	if(follower==null){
    		follower=new User(followerId);
        	users.put(followerId, follower);
    	}
    	if(!followed.followed.contains(follower)){
    		followed.followed.add(follower);
        	follower.news.addAll(followed.mys);
        	follower.news.sort(new Comparator<Twitt>() {
    			@Override
    			public int compare(Twitt o1, Twitt o2) {
    				// TODO Auto-generated method stub
    				return (int)(o2.time-o1.time);
    			}
    		});
    	}
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
    	if(followerId==followeeId)
    		return;
    	User followed=users.get(followeeId);
    	if(followed==null){
    		followed=new User(followeeId);
        	users.put(followeeId, followed);
    	}
    	User follower=users.get(followerId);
    	if(follower==null){
    		follower=new User(followerId);
        	users.put(followerId, follower);
    	}
    	followed.followed.remove(follower);
    	follower.news.removeAll(followed.mys);
    }
}
