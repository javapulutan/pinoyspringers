package ph.com.pinoyspringers.salesasst;


/**
 * 
 * @author JSEE
 * @since 09/02/2009
 * @version 1.0
 */
public abstract class DBEntity<T> extends BaseEntity {

	/**
	 * 
	 */
	public abstract void persist();
	
	/**
	 * 
	 */
	public abstract void merge();

	/**
	 * 
	 */
	public abstract void delete();

}
