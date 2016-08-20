package trash;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.bucketlist.dto.GuestBrdVO;

@Repository("guestDAO")
public class GuestBrdDAO extends AbstractDAO{

	@SuppressWarnings("unchecked")
	public List<GuestBrdVO> getUserList(){
		System.out.println("---------GuestBrdDAO");
		return (List<GuestBrdVO>)selectList("guestVO.list");
	}
}
