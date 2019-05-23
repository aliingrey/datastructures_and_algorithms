/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab9;

import java.util.Set;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sonia
 */
public interface Map<K,V> {
    public int size();
// post: returns the number of entries in the map
public boolean isEmpty();
// post: returns true iff this map does not contain any entries
public boolean containsKey(K k);
// pre: k is non-null
// post: returns true iff k is in the domain of the map
public boolean containsValue(V v);
// pre: v is non-null
// post: returns true iff v is the target of at least one map entry;
// that is, v is in the range of the map
public V get(K k);
// pre: k is a key, possibly in the map
// post: returns the value mapped to from k, or null
public V put(K k, V v);
// pre: k and v are non-null
// post: inserts a mapping from k to v in the map
public V remove(K k);
// pre: k is non-null
// post: removes any mapping from k to a value, from the mapping
public void putAll(Map<K,V> other);
// pre: other is non-null
// post: all the mappings of other are installed in this map,
// overriding any conflicting maps
public void clear();
// post: removes all map entries associated with this map
public Set<K> keySet();
// post: returns a set of all keys associated with this map
public Set<V> values();
// post: returns a structure that contains the range of the map
public Set<Association<K,V>> entrySet();
// post: returns a set of (key-value) pairs, generated from this map
public boolean equals(Object other);
// pre: other is non-null
// post: returns true iff maps this and other are entry-wise equal
public int hashCode();
// post: returns a hash code associated with this structure
}
