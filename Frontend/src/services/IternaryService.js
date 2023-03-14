import axios from "axios";

class IternaryService {
  constructor() {
    this.baseUrl = "http://localhost:8080/";
  }

  addIternaries(iternary) {
    return axios.post(this.baseUrl + "iternery/additerneries", iternary);
  }

  updateIterneries(iternery) {
    return axios.put(this.baseUrl + "iternery/updateiterneries", iternery);
  }

  deleteIternery(iternaryId) {
    return axios.delete(this.baseUrl + "iternery/deleteiternery/" + iternaryId);
  }

  getAllIternaries() {
    return axios.get(this.baseUrl + "iternery/alliterneries");
  }
}

export default new IternaryService();
