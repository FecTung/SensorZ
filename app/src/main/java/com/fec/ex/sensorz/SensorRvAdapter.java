package com.fec.ex.sensorz;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Fe2Cu on 2017.05.16.
 */

public class SensorRvAdapter extends RecyclerView.Adapter<SensorRvAdapter.ViewHolder> {

    private OnItemClickListener listener;
    private List<SensorItem> mSensors;
    private Context mContext;

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public SensorRvAdapter(Context mContext, List<SensorItem> sensors) {
        this.mContext = mContext;
        this.mSensors = sensors;
    }

    public Context getContext() {
        return mContext;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View sensorView = inflater.inflate(R.layout.item_sensor, parent, false);
        ViewHolder viewHolder = new ViewHolder(sensorView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        SensorItem sensorItem = mSensors.get(position);

        TextView tvSensorName = holder.mTVSensorName;
        TextView tvSensorType = holder.mTVSensorValue;

        tvSensorName.setText(sensorItem.getSensorName());
        tvSensorType.setText(sensorItem.getSensorType() + "");
    }

    @Override
    public int getItemCount() {
        return mSensors.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView mTVSensorName;
        private TextView mTVSensorValue;

        public ViewHolder(final View itemView) {
            super(itemView);
            mTVSensorName = (TextView) itemView.findViewById(R.id.tvSensorItemName);
            mTVSensorValue = (TextView) itemView.findViewById(R.id.tvSensorItemType);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(itemView, position);
                        }
                    }
                }
            });
        }
    }
}
