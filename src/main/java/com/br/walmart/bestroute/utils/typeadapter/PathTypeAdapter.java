package com.br.walmart.bestroute.utils.typeadapter;

import java.io.IOException;

import com.br.walmart.bestroute.objects.dto.PathDTO;
import com.br.walmart.bestroute.objects.interfaces.PathInterface;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

public class PathTypeAdapter extends TypeAdapter<PathInterface> {

	@Override
	public PathInterface read(JsonReader in) throws IOException {
		PathDTO pathDTO = new PathDTO();
		
		in.beginObject();
		while (in.hasNext()) {
			switch(in.nextName()) {
				case "start":
					pathDTO.setStart(in.nextString());
					break;
				case "end":
					pathDTO.setEnd(in.nextString());
					break;
				case "distance":
					pathDTO.setDistance(in.nextDouble());
					break;
			}
		}
		in.endObject();
		
		return pathDTO;
	}

	@Override
	public void write(JsonWriter out, PathInterface pathDTO) throws IOException {
		out.beginObject();
		out.name("start").value(pathDTO.getStart());
		out.name("end").value(pathDTO.getEnd());
		out.name("distance").value(pathDTO.getDistance());
		out.endObject();
	}

}
