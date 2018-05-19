package baodavi;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class Twitter {

	private static int timeStamp = 0;
	// key - user id
	// val - user object
	private Map<Integer, User> userMap;
	
	private class Tweet{
		public int id;
		public int time;
		public Tweet next;
		public Tweet(int id){
			this.id = id;
			this.time = timeStamp++;
			this.next = null;
		}
	}
	
	private class User{
		public int id;
		public Set<Integer> followed;
		public Tweet tweetHead;
		public User(int id){
			this.id = id;
			this.followed = new HashSet<>();
			follow(id); // first follow herself
			this.tweetHead = null;
		}
		public void follow(int id){
			this.followed.add(id);
		}
		public void unfollow(int id){
			if(id != this.id){
				this.followed.remove(id); // cannot unfollow herself
			}
		}
		public void post(int id){
			Tweet t = new Tweet(id);
			t.next = this.tweetHead;
			this.tweetHead = t;
		}
	}
	
    /** Initialize your data structure here. */
    public Twitter() {
        this.userMap = new HashMap<>();
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if(!this.userMap.containsKey(userId)){
        	User u = new User(userId);
        	this.userMap.put(userId, u);
        }
        this.userMap.get(userId).post(tweetId);
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new LinkedList<>();
        if(!userMap.containsKey(userId))	return res;
        Set<Integer> users = userMap.get(userId).followed;
        PriorityQueue<Tweet> queue = new PriorityQueue<Tweet>(users.size(), new Comparator<Tweet>(){
			@Override
			public int compare(Tweet o1, Tweet o2) {
				return o2.time - o1.time;
			}
        });
        for(int user : users){
        	Tweet t = userMap.get(user).tweetHead;
        	if(t != null){
        		queue.add(t);
        	}
        }
        int n = 0;
        while(!queue.isEmpty() && n < 10){
        	Tweet t = queue.poll();
        	res.add(t.id);
        	n++;
        	if(t.next != null){
        		queue.add(t.next);
        	}
        }
        return res;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if(!userMap.containsKey(followerId)){
            User u = new User(followerId);
            userMap.put(followerId, u);
        }
        if(!userMap.containsKey(followeeId)){
            User u = new User(followeeId);
            userMap.put(followeeId, u);
        }
        userMap.get(followerId).follow(followeeId);
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if(!userMap.containsKey(followerId) || followerId==followeeId)
            return;
        userMap.get(followerId).unfollow(followeeId);
    }
}
