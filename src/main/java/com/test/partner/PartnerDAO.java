package com.test.partner;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.test.tripnow.DBUtil;

public class PartnerDAO {
	
	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;
	
	public PartnerDAO() {
		conn = DBUtil.open();
	}

	public ArrayList<HomeBookManageDTO> homebookmanage(String pid) {

		try {
			
			String sql = "select r.path, h.name as homename, r.name as roomname, r.price, hb.startdate, hb.enddate, u.name, u.id, u.tel, hb.bsseq, hb.seq from tblHomeBook hb inner join tblRoom r on hb.rseq = r.seq inner join tblUser u on hb.id = u.id inner join tblHome h on r.hseq = h.seq where h.pid = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, pid);
			
			rs = pstat.executeQuery();
			
			ArrayList<HomeBookManageDTO> bmlist = new ArrayList<HomeBookManageDTO>();
			
			while(rs.next()) {
				
				HomeBookManageDTO dto = new HomeBookManageDTO();
				
				dto.setPath(rs.getString("path"));
				dto.setHomename(rs.getString("homename"));
				dto.setRoomname(rs.getString("roomname"));
				dto.setPrice(rs.getString("price"));
				dto.setStartdate(rs.getString("startdate"));
				dto.setEnddate(rs.getString("enddate"));
				dto.setName(rs.getString("name"));
				dto.setId(rs.getString("id"));
				dto.setTel(rs.getString("tel"));
				dto.setBsseq(rs.getString("bsseq"));
				dto.setSeq(rs.getString("seq"));
				
				bmlist.add(dto);
				
			}
			
			return bmlist;
			
		} catch (Exception e) {
			System.out.println("PartnerDAO.bookmanage");
			e.printStackTrace();
		}
		
		return null;
	}

	public int homebookcancel(String seq) {
		
		try {
			
			String sql = "update tblHomeBook set bsseq = 4 where seq = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, seq);
			
			int result = pstat.executeUpdate();
			
			return result;
			
		} catch (Exception e) {
			System.out.println("PartnerDAO.homebookcancel");
			e.printStackTrace();
		}
		
		return 0;
	}

	public int homebookconfirm(String seq) {
		
		try {
			
			String sql = "update tblHomeBook set bsseq = 2 where seq = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, seq);
			
			int result = pstat.executeUpdate();
			
			return result;
			
		} catch (Exception e) {
			System.out.println("PartnerDAO.homebookconfirm");
			e.printStackTrace();
		}

		return 0;
	}

	public ArrayList<ActivityBookManageDTO> activitybookmanage(String pid) {

		try {
			
			String sql = "select a.path, a.name, p.finalprice, ab.count, u.id, u.name as username, u.tel, ab.bsseq, ab.seq from tblActivity a inner join tblActivitybook ab on a.seq = ab.aseq inner join tblUser u on ab.id = u.id inner join tblBookList bl on ab.blseq = bl.seq inner join tblPayment p on bl.seq = p.blseq where a.pid = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, pid);
			
			rs = pstat.executeQuery();
			
			ArrayList<ActivityBookManageDTO> amlist = new ArrayList<ActivityBookManageDTO>();
			
			while (rs.next()) {
				
				ActivityBookManageDTO dto = new ActivityBookManageDTO();
				
				dto.setPath(rs.getString("path"));
				dto.setName(rs.getString("name"));
				dto.setFinalprice(rs.getString("finalprice"));
				dto.setCount(rs.getString("count"));
				dto.setId(rs.getString("id"));
				dto.setUsername(rs.getString("username"));
				dto.setTel(rs.getString("tel"));
				dto.setBsseq(rs.getString("bsseq"));
				dto.setSeq(rs.getString("seq"));
				
				amlist.add(dto);
				
			}
			
			return amlist;
			
		} catch (Exception e) {
			System.out.println("PartnerDAO.activitybookmanage");
			e.printStackTrace();
		}
		
		return null;
	}

	public int activitybookcancel(String seq) {
		
		try {
			
			String sql = "update tblActivityBook set bsseq = 4 where seq = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, seq);
			
			int result = pstat.executeUpdate();
			
			return result;
			
		} catch (Exception e) {
			System.out.println("PartnerDAO.activitybookcancel");
			e.printStackTrace();
		}
		
		return 0;
		
	}

	public int activitybookconfirm(String seq) {
		
		try {
			
			String sql = "update tblActivityBook set bsseq = 2 where seq = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, seq);
			
			int result = pstat.executeUpdate();
			
			return result;
			
		} catch (Exception e) {
			System.out.println("PartnerDAO.homebookconfirm");
			e.printStackTrace();
		}

		return 0;
		
	}

	public ArrayList<CarBookManageDTO> carbookmanage(String pid) {

		try {
			
			String sql = "select cn.path, c.carname, p.finalprice, cb.startdate, cb.enddate, u.id, u.name, u.tel, cb.bsseq, cb.seq from tblCar c inner join tblcarname cn on c.carname = cn.seq inner join tblCarBook cb on cb.cseq = c.seq inner join tblUser u on cb.id = u.id inner join tblBookList bl on cb.bseq = bl.seq inner join tblPayment p on bl.seq = p.blseq where c.pid = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, pid);
			
			rs = pstat.executeQuery();
			
			ArrayList<CarBookManageDTO> cmlist = new ArrayList<CarBookManageDTO>();
			
			while (rs.next()) {
				
				CarBookManageDTO dto = new CarBookManageDTO();
				
				dto.setPath(rs.getString("path"));
				dto.setCarname(rs.getString("carname"));
				dto.setFinalprice(rs.getString("finalprice"));
				dto.setStartdate(rs.getString("startdate"));
				dto.setEnddate(rs.getString("enddate"));
				dto.setId(rs.getString("id"));
				dto.setName(rs.getString("name"));
				dto.setTel(rs.getString("tel"));
				dto.setBsseq(rs.getString("bsseq"));
				dto.setSeq(rs.getString("seq"));
				
				cmlist.add(dto);
				
			}
			
			return cmlist;
			
		} catch (Exception e) {
			System.out.println("PartnerDAO.carbookmanage");
			e.printStackTrace();
		}

		return null;
	}

	public int carbookcancel(String seq) {

		try {
			
			String sql = "update tblCarBook set bsseq = 4 where seq = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, seq);
			
			int result = pstat.executeUpdate();
			
			return result;
			
		} catch (Exception e) {
			System.out.println("PartnerDAO.carbookcancel");
			e.printStackTrace();
		}

		return 0;
	}

	public int carbookconfirm(String seq) {

		try {
			
			String sql = "update tblCarBook set bsseq = 2 where seq = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, seq);
			
			int result = pstat.executeUpdate();
			
			return result;
			
		} catch (Exception e) {
			System.out.println("PartnerDAO.carbookconfirm");
			e.printStackTrace();
		}
		
		return 0;
	}

	public int insertHome(HomeAddInfoDTO dto) {
		
		try {
			
			String sql = "insert into tblHome values ((select max(seq)+1 from tblHome), ?, ?, ?, ?, ?, ?)";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, dto.getPid());
			pstat.setString(2, dto.getTseq());
			pstat.setString(3, dto.getHomename());
			pstat.setString(4, dto.getLocation());
			pstat.setString(5, dto.getEnter());
			pstat.setString(6, dto.getOuter());
			
			int result = pstat.executeUpdate();
			
			return result;
			
		} catch (Exception e) {
			System.out.println("PartnerDAO.insertHome");
			e.printStackTrace();
		}
		
		return 0;
	}

	public int insertRoom(HomeAddInfoDTO dto) {
		
		try {
			
			String sql = "insert into tblRoom values ((select max(seq)+1 from tblRoom), (select max(seq) from tblHome), 1, ?, ?, ?, 'n')";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, dto.getRoomname());
			pstat.setString(2, dto.getPrice());
			pstat.setString(3, "images/" + dto.getThumbnail());
			
			int result = pstat.executeUpdate();
			
			return result;
			
		} catch (Exception e) {
			System.out.println("PartnerDAO.insertRoom");
			e.printStackTrace();
		}
		
		
		return 0;
	}

	public int insertOptionList(HomeAddInfoDTO dto) {

		try {
			
			String sql = "insert into tblOptionList values ((select max(seq) + 1 from tblOptionList), (select max(seq) from tblRoom), ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, dto.getBedoption());
			pstat.setString(2, dto.getBath());
			pstat.setString(3, dto.getPet());
			pstat.setString(4, dto.getMaxpeople());
			pstat.setString(5, dto.getSmoke());
			pstat.setString(6, dto.getPool());
			pstat.setString(7, dto.getParking());
			pstat.setString(8, dto.getCook());
			pstat.setString(9, dto.getWifi());
			
			int result = pstat.executeUpdate();
			
			return result;
			
		} catch (Exception e) {
			System.out.println("PartnerDAO.insertOptionList");
			e.printStackTrace();
		}

		return 0;
	}

	public int insertRoompic(HomeAddInfoDTO dto) {

		try {
			
			String sql = "";
			int result = 0;
			
			for (int i=0; i<dto.getFilename().size()-1; i++) {
				
				sql = "insert into tblRoomPic values ((select max(seq) + 1 from tblRoomPic), (select max(seq) from tblRoom), ?)";
				
				pstat = conn.prepareStatement(sql);
				pstat.setString(1, "images/" + dto.getFilename().get(i));
				
				result += pstat.executeUpdate();
				
			}
			
			if (result == dto.getFilename().size()-1) {
				result = 1;
				return result;
			}
			
		} catch (Exception e) {
			System.out.println("PartnerDAO.insertRoompic");
			e.printStackTrace();
		}

		return 0;
	}

}







































