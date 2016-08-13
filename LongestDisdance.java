package Xcalar;

public class LongestDisdance {
	/*
	 * Complete the function below.
	 */
	/*
	 * Complete the function below.
	 */

	/*const int MAX_WORD_LENG = 51;
	const int MAX_WORD_CNT = 50001;

	const int MOD = 10000; //为何是10000
	const int MAGIC = 123;

	// dump the strings into conresponding bucket
	// e.g. bucket linked list [1] -> all the string with length 1
	void dump2bucket( char **input, int N, int* head, int* nxt) {
	    for(int i = 0; i <= MAX_WORD_LENG; i++) {
	        head[i] = -1;
	    }
	    
	    for(int i = 0; i < N; i++) {
	        int leng_i = strlen(input[i]);
	        nxt[i] = head[leng_i];
	        head[leng_i] = i;
	    }
	}


	class MyHash {
	    public:
	        MyHash() : num_strs(0) {
	            // initialize the head of linked lists
	            memset(head, -1, sizeof(head));  
	        }
	    
	        // function find
	        // return the chain length if found
	        // return -1 if not found
	        int find(char* str, int leng, int drop_idx) {
	            int h_value = hash(str, leng, drop_idx);
	            
	            for(int ptr = head[h_value]; ptr != -1; ptr = next[ptr]) {
	                if(same_str(dicts[ptr], str, drop_idx)) {
	                    return word_dist[ptr];
	                }
	            }
	            
	            return -1;
	        }
	        
	        // insert the string with leng(strlen) and chain length dist 
	        // into the hash table
	        void insert(char* str, int leng, int dist) {
	            int h_value = hash(str, leng);
	            next[num_strs] = head[h_value];
	            head[h_value] = num_strs;
	            word_dist[num_strs] = dist;
	            dicts[num_strs] = str;
	            
	            ++ num_strs;
	        }
	    private:
	        // return true if shorter is same as longer(erasing the char at drop_idx)
	        bool same_str(char* shorter, char* longer, int drop_idx) {
	            int i = 0, j = 0;
	            int lenga = strlen(shorter);
	            int lengb = strlen(longer);
	            if(lenga + 1 != lengb) 
	                return false;
	            
	            while(i < lenga) {
	                if(j == drop_idx) ++j;
	                if(shorter[i] != longer[j]) {
	                    return false;
	                }
	                ++i; 
	                ++j;
	            }
	            
	            return true;
	        }
	        
	        // return the hash value for string (erasing char at drop_idx)
	        int hash(char* str, int leng, int drop_idx = -1) {
	            int ret = 0;
	            for(int i = 0;i < leng; i++) {
	                if(i != drop_idx) {
	                    ret += (int)(str[i]);
	                    ret *= MAGIC;
	                }
	            }
	            ret = ret >= 0 ? ret : -ret;
	            ret %= MOD;
	            
	            return ret;
	        }
	        
	        int head[MOD];
	        int next[MAX_WORD_CNT];
	        int word_dist[MAX_WORD_CNT];
	        char* dicts[MAX_WORD_CNT];
	        int num_strs;
	};

	int longestChain(int words_size,  char** words) {
	    // Bucket linked list definition
	    // head[0] -> element1 -> element2 -> ...
	    int head[MAX_WORD_LENG];
	    int *nxt = new int[words_size];
	    
	    MyHash _hash;
	    
	    // dump the strings into conresponding bucket
	    // e.g. bucket linked list [1] -> all the string with length 1
	    dump2bucket(words, words_size, head, nxt);
	    
	    int ret = 0;
	    
	    for(int leng = 0; leng <= 50; leng++) {
	        // for all the string in bucket [with length leng]
	        for(int ptr = head[leng]; ptr != -1; ptr = nxt[ptr]) {
	            // get the string
	            char* str = words[ptr];
	            
	            int dis_str = 1;
	            for(int i = 0; i < leng; i++) {
	                // erase one character from the string, and 
	                // find the pre_string from the _hash table
	                // return the chain length if found
	                // return -1 if not found
	                int pre_dist = _hash.find(str, leng, i);
	                dis_str = max(dis_str, pre_dist + 1);
	            }
	            _hash.insert(str, leng, dis_str);
	            
	            ret = max(ret, dis_str);
	        }
	    }
	    
	    delete[] nxt;
	    return ret;

	}

	// Change the api from C++ to C
	int longestChain(vector < string > words) {
	    int N = words.size();
	    char** input = new char*[N];
	    for(int i = 0; i < N; i++) {
	        input[i] = const_cast<char*>(words[i].data()); //用法不太懂
	    }
	    int ret = longestChain(N, input);
	    delete [] input;
	    
	    return ret;
	}*/


}
