/**
 * 
 */
package interview.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.hateoas.ResourceSupport;

import interview.system.core.Domain;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author zhouufen
 *
 */
@Entity
@Setter
@Getter
@ToString
public class Interview  extends ResourceSupport implements Domain{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idinterview;

	@Column
	private String inDu;
	@Column
	private String inLine;
	@Column
	private String inPosition;
	@Column
	private String inStatus;
	@Column
	private String in_comment;
	private String inOwner;
	@Column
	private int cvId;
	@Column
	private boolean inEnable;

	@CreatedDate
	private Date inDate;

	@LastModifiedDate
	private Date in_last_update_date;

	/*@JsonCreator
	public Interview(int idinterview, String in_du, String in_line, String in_position, String in_status,
			String in_comment, String in_owner, int cv_id, boolean in_enable, Date in_date, @JsonProperty("content") String content) {
		super();
		this.idinterview = idinterview;
		this.in_du = in_du;
		this.in_line = in_line;
		this.in_position = in_position;
		this.in_status = in_status;
		this.in_comment = in_comment;
		this.in_owner = in_owner;
		this.cv_id = cv_id;
		this.in_enable = in_enable;
		this.in_date = in_date;
		this.content = content;
	}
	public Interview() {
		super();
	}*/
	
}
