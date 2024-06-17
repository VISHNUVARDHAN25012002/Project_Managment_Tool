package channel.com.Service;

import channel.com.Entity.Channel;
import channel.com.Repository.ChannelRepository;
import channel.com.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChannelService {

    @Autowired
    private ChannelRepository channelRepository;

    public List<Channel> getAllChannels() {
        return channelRepository.findAll();
    }

    public Optional<Channel> getChannelById(Long id) {
        return channelRepository.findById(id);
    }

    public Channel saveChannel(Channel channel) {
        return channelRepository.save(channel);
    }

    public Channel updateChannel(Long id, Channel channelDetails) {
        Channel channel = channelRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Channel not found for this id :: " + id));

        channel.setName(channelDetails.getName());
        channel.setDescription(channelDetails.getDescription());
        return channelRepository.save(channel);
    }

    public void deleteChannel(Long id) {
        Channel channel = channelRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Channel not found for this id :: " + id));
        channelRepository.delete(channel);
    }
}

